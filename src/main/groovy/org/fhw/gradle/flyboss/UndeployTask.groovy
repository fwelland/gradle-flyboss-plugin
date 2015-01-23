package org.fhw.gradle.flyboss

import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.Input
import org.gradle.api.DefaultTask
import org.apache.tools.ant.taskdefs.condition.Os


class UndeployTask extends BaseTask {
    	        
    @TaskAction
    def undeploy() {

        def binDir = getBinDir()
        if( isUp() )
        { 
            executeCLICommand("undeploy", getDeploymentName())
        }
        else
        {
            println "start app server first"
        }
    }
}


