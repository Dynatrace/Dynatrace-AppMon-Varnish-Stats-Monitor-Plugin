## Varnish Stats Monitor Plugin
![images_community/download/attachments/130516772/icon.png](images_community/download/attachments/130516772/icon.png) Varnish is a web application accelerator. You install it in front of your web
application and it will speed it up significantly.

The varnishStat Plugin enables monitoring key stats from the varnishstas utility. The plugin uses ssh to connect to a Linux server and then executesvarnishstats -j to pull back the varnish stats in
Json format. The plugin then creates the varnish stat measures in dynaTrace by parsing the Json inputStream.

Find further information in the [dynatrace community](https://community.compuwareapm.com/community/display/DL/Varnish+Stats+Monitor+Plugin)