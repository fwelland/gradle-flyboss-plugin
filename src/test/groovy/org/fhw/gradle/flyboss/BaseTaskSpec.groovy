package org.fhw.gradle.flyboss

import spock.lang.Specification
import org.gradle.testfixtures.ProjectBuilder
import org.gradle.api.Project

class BaseTaskSpec extends Specification {

    def "Test Get AppServer Bin Directory Default"()
    {
        given: 
            Project project = ProjectBuilder.builder().build()
            project.apply plugin: 'flyboss'
            
        when:
            String  binDir = project.tasks.deploy.getBinDir()
            
        then:  
            binDir == "/opt/wildfly/bin"
    }
    
    def "Test Get CLI Script Default"()
    {
        given: 
            Project project = ProjectBuilder.builder().build()
            project.apply plugin: 'flyboss'
            
        when:
            String  cli = project.tasks.deploy.getCliScript()
            
        then:  
            cli == '/opt/wildfly/bin/jboss-cli.sh'
    }
    
    def "Test Get CLI Script name default"()
    {
        given: 
            Project project = ProjectBuilder.builder().build()
            project.apply plugin: 'flyboss'
            
        when:
            String  cli = project.tasks.deploy.getCliScriptName()
            
        then:  
            cli == 'jboss-cli.sh'
    }    
    
    
    
    def "Test Get Appserver Bin Directory with spcified base"()
    {
        given: 
            Project project = ProjectBuilder.builder().build()
            project.apply plugin: 'flyboss'
            project.flyboss.appserver_home = '/opt/yar'
            
        when:
            String  binDir = project.tasks.deploy.getBinDir()
            
        then:  
            binDir == "/opt/yar/bin"        
    }
    
    def "Test ability to fetch the deployment name when flyboss plugin closure provides a name "()
    {
        given: 
            Project project = ProjectBuilder.builder().build()
            project.apply plugin: 'flyboss'
            project.flyboss.path_to_deployable = '/usr/overthere/frank-burns.ear'
            
        when:
            String  nme = project.tasks.deploy.getDeploymentName()
            
        then:  
            nme == "frank-burns.ear"        
    }    

    def "Test Get To See if CLI script is On Execution Path -- dummy yes case"()
    {
        given: 
            Project project = ProjectBuilder.builder().build()
            project.apply plugin: 'flyboss'
            project.flyboss.appserver_cli_script=  'ls'
            
        when:
            def rc = project.tasks.deployExploded.isCLIScriptOnPath()
            
        then:  
            rc
    }
    
    
    def "Test Get To See if CLI script is On Execution Path -- dummy no case"()
    {
        given: 
            Project project = ProjectBuilder.builder().build()
            project.apply plugin: 'flyboss'
            project.flyboss.appserver_cli_script=  'xxlsrrrpinkturtle'
            
        when:
            def rc = project.tasks.deployExploded.isCLIScriptOnPath()
            
        then:  
            !rc
    }           
    
    def "Test startup command options"()
    {
        given: 
            Project project = ProjectBuilder.builder().build()
            project.apply plugin: 'flyboss'
            project.flyboss.appserver_start_script_options = ["-b", "0.0.0.0"]
            
        when:
            def lst = project.tasks.start.getAppServerStartScriptOptions()
            
        then:
            lst == ['-b', '0.0.0.0'] 
    }               
    
    
    def "Test format of start command with options"()
    {
        given: 
            Project project = ProjectBuilder.builder().build()
            project.apply plugin: 'flyboss'
            project.flyboss.appserver_home = ''
            project.flyboss.appserver_start_script= 'start'            
            project.flyboss.appserver_start_script_options = ['-b', '0.0.0.0']
            
        when:
            def lst = project.tasks.start.makeStartCommandLine()
            
        then:
            lst == ['/bin/start','-b', '0.0.0.0'] 
    }                   
}

