package org.fhw.gradle.flyboss

import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.Input
import org.gradle.api.DefaultTask
import org.apache.tools.ant.taskdefs.condition.Os


class StopTask extends BaseTask {
    	
    @TaskAction
    def stop() {
        def binDir = getBinDir()
        if( isUp() )
        {        
            executeCLICommand('shutdown')
        }
    }
}
