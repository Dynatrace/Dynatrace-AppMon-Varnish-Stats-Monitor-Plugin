# Varnish Stats Monitor Plugin

## Overview

![images_community/download/attachments/130516772/icon.png](images_community/download/attachments/130516772/icon.png) Varnish is a web application accelerator. You install it in front of your web
application and it will speed it up significantly.

The varnishStat Plugin enables monitoring key stats from the varnishstas utility. The plugin uses ssh to connect to a Linux server and then executesvarnishstats -j to pull back the varnish stats in
Json format. The plugin then creates the varnish stat measures in dynaTrace by parsing the Json inputStream.

## Plugin Details

| Name | Varnish Stats Monitor Plugin
| :--- | :---
| Author | Jeff Yarbrough
| Supported dynaTrace Versions | >= 5.5
| License | [dynaTrace BSD](dynaTraceBSD.txt)
| Support Level | [Not Supported ](https://community.compuwareapm.com/community/display/DL/Support+Levels#SupportLevels-Community)  
| Release History | 2013-07-25 Initial Release
| Download | [varnishstat.1.0.7](com.dynatrace.diagnostics.plugin.varnish_1.0.7.jar)
| | [varnishstat.1.0.8](com.dynatrace.diagnostics.plugin.Varnish_1.0.8.jar)


## Installation

### Import Plugin:

![images_community/download/attachments/130516772/Screen_Shot_2013-07-25_at_4.14.03_PM.png](images_community/download/attachments/130516772/Screen_Shot_2013-07-25_at_4.14.03_PM.png)

Import the Plugin into the dynaTrace Server. For details how to do this please refer to the [dynaTrace
documentation](https://community.dynatrace.com/community/display/DOCDT50/Manage+and+Develop+User+Plugins).

After you import the plugin you will see the plugin as VarnishStats, type of plugin "Monitor Metric Group, Monitor".

### Setup Monitor:

Under your system profile, you will need to create a monitor for the varnish plugin. Select Monitors under the profile and select "Create".

![images_community/download/attachments/130516772/Screen_Shot_2013-07-25_at_11.08.56_AM.png](images_community/download/attachments/130516772/Screen_Shot_2013-07-25_at_11.08.56_AM.png)

Select the VarnishStats monitor and click "ok".

### Configure Monitor:

You will need to provide the login credentials (username/password) for the Linux host and give the monitor a name.

![images_community/download/attachments/130516772/Screen_Shot_2013-07-25_at_11.09.42_AM.png](images_community/download/attachments/130516772/Screen_Shot_2013-07-25_at_11.09.42_AM.png)

Make sure to add a host or hosts to the host configuration.

![images_community/download/attachments/130516772/Screen_Shot_2013-07-25_at_11.09.27_AM.png](images_community/download/attachments/130516772/Screen_Shot_2013-07-25_at_11.09.27_AM.png)

Set the schedule,

![images_community/download/attachments/130516772/Screen_Shot_2013-07-25_at_11.10.46_AM.png](images_community/download/attachments/130516772/Screen_Shot_2013-07-25_at_11.10.46_AM.png)

(Optionally) You can select which measures you would like to subscribe.

![images_community/download/attachments/130516772/Screen_Shot_2013-07-25_at_11.15.22_AM.png](images_community/download/attachments/130516772/Screen_Shot_2013-07-25_at_11.15.22_AM.png)

Click "OK", then you should see the Monitor has been created.

![images_community/download/attachments/130516772/Screen_Shot_2013-07-25_at_11.16.06_AM.png](images_community/download/attachments/130516772/Screen_Shot_2013-07-25_at_11.16.06_AM.png)

### Validation:

You will need select the monitor and click "Run Now", the monitor should display a green indicator to let you know everything worked.

### Measures:

You can now see the measure for VarnishStats under "System Monitoring".

![images_community/download/attachments/130516772/Screen_Shot_2013-07-25_at_11.18.27_AM.png](images_community/download/attachments/130516772/Screen_Shot_2013-07-25_at_11.18.27_AM.png)

### Configuration

| Name | Value
| :--- | :---
| Username | The username to use for authentication to the restful interface
| Password | The password for the username used to authenticate to the restful interface.
| command | (optional) default is "varnish stat -j"

