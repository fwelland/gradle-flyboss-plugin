# gradle-flyboss-plugin
Refactor of my other gradle wildfly plugin to work against jboss eap and wildfly. 

Additional details can be found on this [blog post](http://stupidfredtricks.blogspot.com/2015/02/gradle-flyboss-plugin.html) 

This plugin really just uses the local 'jboss-cli' script to do it's work.   It also really only functions against the standalone jboss instance.

Here is a quick sample of a build file that is part of multi-part gradle project.   This is a standalone gradle file that simply deploys
to and starts/stops an app server (in this case a jboss instance) on local workstation.  

```
    apply plugin: 'flyboss'
    buildscript {
        repositories {
            maven {
                url 'http://dl.bintray.com/fwelland/FredsStuff'
            }
        }   
        dependencies {
            classpath 'org.fhw:gradle-flyboss-plugin:0.1'
        }
    }
    flyboss {
       appserver_home = '/opt/jboss'
       path_to_deployable =  tasks.getByPath(':main:ear:ear').archivePath
    }
    deploy.dependsOn  ':main:ear:ear'
    task build (dependsOn: deploy )
```


