package org.fhw.gradle.flyboss

import org.gradle.api.Project
import org.gradle.api.Plugin

class FlyBossPlugin implements Plugin<Project> {
        
    @Override
    void apply(Project project) {        
                
        project.extensions.create("flyboss", FlyBossPluginExtension)        
        project.task('start', type: StartTask)
        project.task('stop', type: StopTask)
        project.task('deploy', type: DeployTask) 
        project.task('undeploy', type: UndeployTask)   
        project.task('deployExploded', type: DeployExplodedTask)
    }       
}
