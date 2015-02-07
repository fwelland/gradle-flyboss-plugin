package org.fhw.gradle.flyboss

import spock.lang.Specification
import org.gradle.testfixtures.ProjectBuilder
import org.gradle.api.Project


class StopTaskSpec extends Specification {
    
    def "Simple stop using default configuration"()
    {
        given: 
            Project project = ProjectBuilder.builder().build()
            project.apply plugin: 'flyboss'
            
        when:
            project.tasks.stop.stop()
            
        then:  
            //
            //use a hack version of 'isUp' to test up-ness
            //we actually want process rc to be not zero
            //
            String foo = project.tasks.stop.getCliScript() + ' ' + '--connect' + ' quit' 
            foo.execute().waitFor() != 0 
    }
    
    
}
    
