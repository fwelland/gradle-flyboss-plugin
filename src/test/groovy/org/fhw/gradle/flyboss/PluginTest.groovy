package org.fhw.gradle.flyboss
import org.junit.Test
import org.gradle.testfixtures.ProjectBuilder
import org.gradle.api.Project
import static org.junit.Assert.*

class PluginTest {
    
    @Test
    public void addPluginTest()
    {
        Project project = ProjectBuilder.builder().build()
        project.apply plugin: 'flyboss'
        assertTrue(project.tasks.deploy instanceof DeployTask)
        assertTrue(project.tasks.undeploy instanceof UndeployTask)
        assertTrue(project.tasks.start instanceof StartTask)
        assertTrue(project.tasks.stop instanceof StopTask)
    }
	
}

