/**
 * This Plugin will pull the varnish stats data.
 * It will run the command varnish -j
 * This returns a Json formatted inputStream from the host Linux machine
 * The plugin will use ssh over port 22
 **/

package com.dynatrace.diagnostics.plugins.varnish;

import com.dynatrace.diagnostics.pdk.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Logger;
import com.jcraft.jsch.*;
import java.util.*;
import org.json.simple.parser.ParseException;
import java.util.Iterator;
import org.json.simple.JSONValue;
import org.json.simple.parser.ContainerFactory;
import org.json.simple.parser.JSONParser;
import com.dynatrace.diagnostics.plugins.varnish.KeyFinder;

public class VarnishMonitor implements Monitor {

	/**
	 * This plugin will retrieve the varnishstat data from a LAMP stack
	 * 
	 **/

	private static final Logger log = Logger.getLogger(VarnishMonitor.class.getName());
	private static final String CONFIG_USERNAME = "serverUsername";
	private static final String CONFIG_PASSWORD = "serverPassword";
	private static final String CONFIG_COMMAND = "command";
	private String username;
	private String password;
	private String host;
	private String command;
	private int port = 22;
	private static final String METRIC_GROUP = "VarnishStats";

	public Status setup(MonitorEnvironment env) throws Exception {
		return new Status(Status.StatusCode.Success);
	}

	public Status execute(MonitorEnvironment env) throws Exception {
		getArgs(env);
		sendCommand(env);
		return new Status(Status.StatusCode.Success);
	}

	public void sendCommand(MonitorEnvironment env) {	
		try {
			JSch jsch = new JSch();
			Session session = jsch.getSession(username, host, port);
			session.setConfig("StrictHostKeyChecking", "no");
			session.setPassword(password);
			session.connect(10000);
			Channel channel = session.openChannel("exec");
			((ChannelExec) channel).setCommand(command);
			channel.setInputStream(null);
			((ChannelExec) channel).setErrStream(System.err);
			InputStream in = channel.getInputStream();
			channel.connect();
			// Begin parse of Json output
			JsonParser(env, in);
			channel.disconnect();
			session.disconnect();
		} catch (Exception e) {
			log.info(e.toString());
		}
	}

	public void JsonParser(MonitorEnvironment env, InputStream in) throws Exception {
		BufferedReader inS = new BufferedReader(new InputStreamReader(in));
		JSONParser parser = new JSONParser();
		/** Container Factory **/
		ContainerFactory containerFactory = new ContainerFactory() {
			public List<Object> creatArrayContainer() {
				return new LinkedList<Object>();
			}
			public Map createObjectContainer() {
				return new LinkedHashMap();
			}
		};
		try {
			Map json = (Map) parser.parse(inS, containerFactory);
			Iterator<?> iter = json.entrySet().iterator();
			/** Get key value pairs **/
			while (iter.hasNext()) {
				Map.Entry entry = (Map.Entry) iter.next();
				 	  String jsonText = JSONValue.toJSONString(entry.getValue());
				 	  JSONParser parser2 = new JSONParser();
				 	  KeyFinder finder = new KeyFinder();
				 	  finder.setMatchKey("value");
				 	  try{
				 	    while(!finder.isEnd()){
				 	      parser2.parse(jsonText, finder, true);
				 	      if(finder.isFound()){
				 	        finder.setFound(false);
				 	      }
				 	    }           
				 	  }
				 	  catch(ParseException pe){
				 	    pe.printStackTrace();
				 	  }				 	
				 	String key = (String) entry.getKey();
				 	if (key.equals("timestamp")) {
				 		log.info("timestamp:"+entry.getValue());
				 	} else {	
				 		setMeasures(env, entry.getKey(), finder.getValue());
				 	}
			}
		} catch (ParseException pe) {
			System.out.println(pe);
		}	
	}		

	public Status setMeasures(MonitorEnvironment env, Object key, Object value) throws Exception {
		String measurename = (String) key;
		double measurevalue = Double.parseDouble(value.toString());		
		//log.info("MeasuerName=>"+measurename);
		//create dynamic measure from the measurename
        if (measurename.equals(measurename)) {
        	String measure = "varnish_"+measurename.toLowerCase();
            Collection<MonitorMeasure> monitorMeasures = env.getMonitorMeasures(METRIC_GROUP, measure);
            for (MonitorMeasure subscribedMonitorMeasure : monitorMeasures) {
            	MonitorMeasure dynamicMeasure = env.createDynamicMeasure(subscribedMonitorMeasure, "VarnishStat", measure);
            	dynamicMeasure.setValue(measurevalue);
            }  
        }   
        	return new Status(Status.StatusCode.Success);
	}

	public void getArgs(MonitorEnvironment env) {
		username = env.getConfigString(CONFIG_USERNAME);
		password = env.getConfigPassword(CONFIG_PASSWORD);
		host = env.getHost().getAddress();
		command = env.getConfigString(CONFIG_COMMAND);
	}

	@Override
	public void teardown(MonitorEnvironment arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
