package org.fhw.gradle.flyboss

import org.gradle.api.tasks.TaskAction

class DeployExplodedTask extends BaseTask {
    	        
    @TaskAction
    def deployExploded() {

        println 'this will be the exploded task'
    }
}


