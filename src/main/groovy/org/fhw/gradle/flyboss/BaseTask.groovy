package org.fhw.gradle.flyboss

import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.Input
import org.gradle.api.DefaultTask
import org.apache.tools.ant.taskdefs.condition.Os


class BaseTask extends DefaultTask {
    

    def getBinDir()
    {
        return project.flyboss.appserver_home + "/bin"
    }
             
    def getAppServerStartScriptOptions()
    {
        project.flyboss.appserver_start_script_options        
    }
    
    
    def makeStartCommandLine()
    {
        def cmd = []
        cmd  << getStarterScript()            
        getAppServerStartScriptOptions().each { cmd << it }                    
        return(cmd)
    }
    
    def getStarterScript()
    {
        return getBinDir() + '/' + project.flyboss.appserver_start_script
    }

    def getCliScript()
    {
        return getBinDir() + '/' + project.flyboss.appserver_cli_script
    }
    
    def getCliScriptName()
    {
        return(project.flyboss.appserver_cli_script)
    }
    
    def getArchiveToDeploy()
    {
        return project.flyboss.path_to_deployable
    }
    
    def getDeploymentName()
    {
        return (new File((String)getArchiveToDeploy()).name)
    }    
    
    def getStartRegex()
    {
        return project.flyboss.start_regex
    }    
        
    def isUp()
    {        
        return( executeCLICommand('quit') )                 
    }        
    
    def executeCLICommand(String ... commands)
    {
        def cmds = [getCliScript(), '--connect']

        def cmd = ''
        for(String s : commands)
        {
            cmd += s
            cmd += ' '
        }                
        cmds.add(cmd)
        ProcessBuilder builder = new ProcessBuilder( cmds )                                               
        builder.directory(new File(getBinDir()))                
        builder.redirectErrorStream(true)
        Process process = builder.start()                
        InputStream stdout = process.getInputStream()
        BufferedReader reader = new BufferedReader(new InputStreamReader(stdout)) 
        def line
        while ((line = reader.readLine()) != null) 
        {   }       
        return( process.waitFor() == 0)                 
    }        
        
    def isCLIScriptOnPath()
    {
        def String cli_ver = getCliScriptName() 
        def rc
        try{
            rc = cli_ver.execute()
        }
        catch(e){
            rc = false
        }
        return(rc)
    }    
}
