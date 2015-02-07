package org.fhw.gradle.flyboss

import spock.lang.Specification
import org.gradle.testfixtures.ProjectBuilder
import org.gradle.api.Project


class StartTaskSpec extends Specification {

    
    def Project project

    def setup(){
        project = ProjectBuilder.builder().build()
        project.apply plugin: 'flyboss'        
    }
    
    def "Simple start using default configuration"(){            
        when:
            project.tasks.start.start()
            
        then:  
            //
            //use a hack version of 'isUp' to test up-ness
            //assume 0 rc is OK. 
            //
            String foo = project.tasks.stop.getCliScript() + ' ' + '--connect' + ' quit' 
            foo.execute().waitFor() == 0 
    }
    
    def "Simple start with configuration for appserver_home"() {
        given: 
            project.flyboss.appserver_home = '/opt/jboss'       
            
        when:
            project.tasks.start.start()
            
        then:  
            //
            //use a hack version of 'isUp' to test up-ness
            //assume 0 rc is OK. 
            //
            String foo = project.tasks.stop.getCliScript() + ' ' + '--connect' + ' quit' 
            foo.execute().waitFor() == 0 
    }    
    
    
    def cleanup() {
        String foo = project.tasks.stop.getCliScript() + ' ' + '--connect' + ' shutdown' 
        foo.execute()
    }
}
    
