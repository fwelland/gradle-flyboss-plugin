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
            if ( !executeCLICommand('shutdown') ) {
                logger.warn('stoping appser server failed; app server may not be known')
            }
        }
        else {
            logger.debug('app server is already stopped')
        }
        
    }
}
