package org.fhw.gradle.flyboss

import org.gradle.api.tasks.TaskAction

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


