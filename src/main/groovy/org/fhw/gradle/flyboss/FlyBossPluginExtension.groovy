package org.fhw.gradle.flyboss

class FlyBossPluginExtension {
    def String appserver_home = '/opt/wildfly'
    def String appserver_start_script = 'standalone.sh'    
    def String appserver_cli_script = 'jboss-cli.sh'
    def String start_regex = '^.*started in.*- Started.*$'    
    def String path_to_deployable = null 
}
   