package org.fhw.gradle.flyboss

import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.Input
import org.gradle.api.DefaultTask
import org.apache.tools.ant.taskdefs.condition.Os


class DeployExplodedTask extends BaseTask {
    	        
    @TaskAction
    def deployExploded() {

        println 'this will be the exploded task'
    }
}


