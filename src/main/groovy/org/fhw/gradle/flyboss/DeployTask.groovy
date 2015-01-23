package org.fhw.gradle.flyboss

import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.Input
import org.gradle.api.DefaultTask
import org.apache.tools.ant.taskdefs.condition.Os


class DeployTask extends BaseTask {
    	        
    @TaskAction
    def deploy() {

        def binDir = getBinDir()
        if( isUp() )
        { 
            executeCLICommand("deploy",getArchiveToDeploy(),"--force")
        }
        else
        {
            println "start appserver  first"
        }
    }
}


