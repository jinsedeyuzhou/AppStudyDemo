package com.moon.plugin
import org.gradle.api.*
import org.gradle.api.provider.Property;

interface GreetingPluginExtension {
    Property<String> getMessage()

    Property<String> getGreeter()
}

class GreetingPlugin implements Plugin<Project> {
    void apply(Project project) {
        def extension = project.extensions.create('greeting', GreetingPluginExtension)
        project.task('hello') {
            doLast {
                println "${extension.message.get()} from ${extension.greeter.get()}"
            }
        }
    }
}
