<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Varnish Stats Monitor Plugin</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
    <meta content="Scroll Wiki Publisher" name="generator"/>
    <link type="text/css" rel="stylesheet" href="css/blueprint/liquid.css" media="screen, projection"/>
    <link type="text/css" rel="stylesheet" href="css/blueprint/print.css" media="print"/>
    <link type="text/css" rel="stylesheet" href="css/content-style.css" media="screen, projection, print"/>
    <link type="text/css" rel="stylesheet" href="css/screen.css" media="screen, projection"/>
    <link type="text/css" rel="stylesheet" href="css/print.css" media="print"/>
</head>
<body>
                <h1>Varnish Stats Monitor Plugin</h1>
    <p>
            <img src="images_community/download/attachments/130516772/icon.png" alt="images_community/download/attachments/130516772/icon.png" class="" />
        Varnish is a web application accelerator.  You install it in front of your web application and it will speed it up significantly.    </p>
    <p>
    <span style="color: #000000;">
     </span>
The varnishStat Plugin enables monitoring key stats from the varnishstas utility.  The plugin uses ssh to connect to a Linux server and then executesvarnishstats &ndash;j to pull back the varnish stats in Json format.  The plugin then creates the varnish stat measures in dynaTrace by parsing the Json inputStream.    </p>
    <div class="tablewrap">
        <table>
<thead class=" "></thead><tfoot class=" "></tfoot><tbody class=" ">    <tr>
            <td rowspan="1" colspan="1">
        <p>
Name and Version    </p>
            </td>
                <td rowspan="1" colspan="1">
        <p>
<a href="attachments_130875553_1_com.dynatrace.diagnostics.plugin.varnish_1.0.7.jar">VarnishStats Monitoring Plugin</a>    </p>
            </td>
                <td rowspan="1" colspan="1">
                </td>
        </tr>
    <tr>
            <td rowspan="1" colspan="1">
        <p>
Compatible with    </p>
            </td>
                <td rowspan="1" colspan="1">
        <p>
dynaTrace 5.x, 6.x    </p>
            </td>
                <td rowspan="1" colspan="1">
                </td>
        </tr>
    <tr>
            <td rowspan="1" colspan="1">
        <p>
Author    </p>
            </td>
                <td rowspan="1" colspan="1">
        <p>
Jeff Yarbrough    </p>
            </td>
                <td rowspan="1" colspan="1">
                </td>
        </tr>
    <tr>
            <td rowspan="1" colspan="1">
        <p>
<a href="https://community/display/DL/Licenses">License</a>    </p>
            </td>
                <td rowspan="1" colspan="1">
        <p>
<a href="attachments_5275722_2_dynaTraceBSD.txt">dynaTrace BSD</a>    </p>
            </td>
                <td rowspan="1" colspan="1">
        <p>
    </p>
            </td>
        </tr>
    <tr>
            <td rowspan="1" colspan="1">
        <p>
<a href="https://community/display/DL/Support+Levels">Support Level</a>    </p>
            </td>
                <td rowspan="1" colspan="1">
        <p>
<a href="https://community.compuwareapm.com/community/display/DL/Support+Levels#SupportLevels-Community">Not Supported </a><br/>If you have any questions or suggestions for these plugins, please add a comment to this page, use our <a href="https://community.dynatrace.com/community/pages/viewpage.action?pageId=46628918">forum</a>, or drop us an email at <a href="mailto:community@dynatrace.com">community@dynatrace.com</a>!    </p>
            </td>
                <td rowspan="1" colspan="1">
        <p>
    </p>
            </td>
        </tr>
    <tr>
            <td rowspan="1" colspan="1">
        <p>
Download    </p>
            </td>
                <td rowspan="1" colspan="1">
        <p>
<a href="attachments_130875553_1_com.dynatrace.diagnostics.plugin.varnish_1.0.7.jar">varnishstat.1.0.7</a>    </p>
    <p>
<a href="attachments_156632336_1_com.dynatrace.diagnostics.plugin.Varnish_1.0.8.jar">varnishstat.1.0.8</a>    </p>
            </td>
                <td rowspan="1" colspan="1">
                </td>
        </tr>
    <tr>
            <td rowspan="1" colspan="1">
        <p>
Installation    </p>
            </td>
                <td rowspan="1" colspan="1">
        <p>
Import the plugin into dynaTrace server    </p>
            </td>
                <td rowspan="1" colspan="1">
                </td>
        </tr>
    <tr>
            <td rowspan="1" colspan="1">
        <p>
Release History    </p>
            </td>
                <td rowspan="1" colspan="1">
        <p>
2013-07-25 Initial Release    </p>
            </td>
                <td rowspan="1" colspan="1">
                </td>
        </tr>
</tbody>        </table>
            </div>
    <div class="section-2"  id="130516772_VarnishStatsMonitorPlugin-Steps%3A"  >
        <h2>Steps:</h2>
    <div class="section-3"  id="130516772_VarnishStatsMonitorPlugin-ImportPlugin%3A"  >
        <h3>Import Plugin:</h3>
    <p>
            <img src="images_community/download/attachments/130516772/Screen_Shot_2013-07-25_at_4.14.03_PM.png" alt="images_community/download/attachments/130516772/Screen_Shot_2013-07-25_at_4.14.03_PM.png" class="" />
            </p>
    <p>
Import the Plugin into the dynaTrace Server. For details how to do this please refer to the <a href="https://community.dynatrace.com/community/display/DOCDT50/Manage+and+Develop+User+Plugins">dynaTrace documentation</a>.    </p>
    <p>
After you import the plugin you will see the plugin as VarnishStats, type of plugin &quot;Monitor Metric Group, Monitor&quot;.    </p>
    </div>
    <div class="section-3"  id="130516772_VarnishStatsMonitorPlugin-SetupMonitor%3A"  >
        <h3>Setup Monitor:</h3>
    <p>
Under your system profile, you will need to create a monitor for the varnish plugin.  Select Monitors under the profile and select &quot;Create&quot;.    </p>
    <p>
            <img src="images_community/download/attachments/130516772/Screen_Shot_2013-07-25_at_11.08.56_AM.png" alt="images_community/download/attachments/130516772/Screen_Shot_2013-07-25_at_11.08.56_AM.png" class="" />
            </p>
    <p>
Select the VarnishStats monitor and click &quot;ok&quot;.    </p>
    </div>
    <div class="section-3"  id="130516772_VarnishStatsMonitorPlugin-ConfigureMonitor%3A"  >
        <h3>Configure Monitor:</h3>
    <p>
You will need to provide the login credentials (username/password) for the Linux host and give the monitor a name.    </p>
    <p>
            <img src="images_community/download/attachments/130516772/Screen_Shot_2013-07-25_at_11.09.42_AM.png" alt="images_community/download/attachments/130516772/Screen_Shot_2013-07-25_at_11.09.42_AM.png" class="" />
            </p>
    <p>
Make sure to add a host or hosts to the host configuration.    </p>
    <p>
            <img src="images_community/download/attachments/130516772/Screen_Shot_2013-07-25_at_11.09.27_AM.png" alt="images_community/download/attachments/130516772/Screen_Shot_2013-07-25_at_11.09.27_AM.png" class="" />
            </p>
    <p>
Set the schedule,    </p>
    <p>
            <img src="images_community/download/attachments/130516772/Screen_Shot_2013-07-25_at_11.10.46_AM.png" alt="images_community/download/attachments/130516772/Screen_Shot_2013-07-25_at_11.10.46_AM.png" class="" />
            </p>
    <p>
(Optionally) You can select which measures you would like to subscribe.    </p>
    <p>
            <img src="images_community/download/attachments/130516772/Screen_Shot_2013-07-25_at_11.15.22_AM.png" alt="images_community/download/attachments/130516772/Screen_Shot_2013-07-25_at_11.15.22_AM.png" class="" />
            </p>
    <p>
Click &quot;OK&quot;, then you should see the Monitor has been created.    </p>
    <p>
            <img src="images_community/download/attachments/130516772/Screen_Shot_2013-07-25_at_11.16.06_AM.png" alt="images_community/download/attachments/130516772/Screen_Shot_2013-07-25_at_11.16.06_AM.png" class="" />
            </p>
    </div>
    <div class="section-3"  id="130516772_VarnishStatsMonitorPlugin-Validation%3A"  >
        <h3>Validation:</h3>
    <p>
You will need select the monitor and click &quot;Run Now&quot;, the monitor should display a green indicator to let you know everything worked.    </p>
    </div>
    <div class="section-3"  id="130516772_VarnishStatsMonitorPlugin-Measures%3A"  >
        <h3>Measures:</h3>
    <p>
You can now see the measure for VarnishStats under &quot;System Monitoring&quot;.    </p>
    <p>
            <img src="images_community/download/attachments/130516772/Screen_Shot_2013-07-25_at_11.18.27_AM.png" alt="images_community/download/attachments/130516772/Screen_Shot_2013-07-25_at_11.18.27_AM.png" class="" />
            </p>
    </div>
    <div class="section-3"  id="130516772_VarnishStatsMonitorPlugin-Configuration"  >
        <h3>Configuration</h3>
    <div class="tablewrap">
        <table>
<thead class=" ">    <tr>
            <td rowspan="1" colspan="1">
        <p>
Name    </p>
            </td>
                <td rowspan="1" colspan="1">
        <p>
Value    </p>
            </td>
        </tr>
</thead><tfoot class=" "></tfoot><tbody class=" ">    <tr>
            <td rowspan="1" colspan="1">
        <p>
Username    </p>
            </td>
                <td rowspan="1" colspan="1">
        <p>
The username to use for authentication to the restful interface    </p>
            </td>
        </tr>
    <tr>
            <td rowspan="1" colspan="1">
        <p>
Password    </p>
            </td>
                <td rowspan="1" colspan="1">
        <p>
The password for the username used to authenticate to the restful interface.    </p>
            </td>
        </tr>
    <tr>
            <td rowspan="1" colspan="1">
        <p>
command    </p>
            </td>
                <td rowspan="1" colspan="1">
        <p>
(optional) default is &quot;varnish stat -j&quot;    </p>
            </td>
        </tr>
</tbody>        </table>
            </div>
    </div>
    </div>
            </div>
        </div>
        <div class="footer">
        </div>
    </div>
</body>
</html>
