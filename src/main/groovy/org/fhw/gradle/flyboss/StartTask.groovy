package org.fhw.gradle.flyboss

import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.Input
import org.gradle.api.DefaultTask
import org.apache.tools.ant.taskdefs.condition.Os


class StartTask extends BaseTask {
    	        
    @TaskAction
    def start() {
        def binDir = getBinDir()
        if( ! isUp() )
        {        
            ProcessBuilder builder = new ProcessBuilder(getAppServerStartCommand())
            builder.directory(new File(binDir))                    
            builder.redirectErrorStream(true)
            Process process = builder.start()            
            InputStream stdout = process.getInputStream()
            BufferedReader reader = new BufferedReader(new InputStreamReader(stdout)) 
            def reggie = getStartRegex()
            def line
            while ((line = reader.readLine()) != null) {
                if (line.matches(reggie)) {
                    logger.info(line)
                    break
                }
            }            
        }
        else
        {
            logger.debug('server already started')
        }
    }
}


