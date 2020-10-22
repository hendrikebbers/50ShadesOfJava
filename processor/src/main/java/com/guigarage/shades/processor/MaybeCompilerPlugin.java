package com.guigarage.shades.processor;

import com.sun.source.util.JavacTask;
import com.sun.source.util.Plugin;
import com.sun.source.util.TaskEvent;
import com.sun.source.util.TaskListener;

public class MaybeCompilerPlugin implements Plugin {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public void init(final JavacTask task, final String... args) {

        task.addTaskListener(new TaskListener() {
            @Override
            public void started(final TaskEvent e) {


            }

            @Override
            public void finished(final TaskEvent e) {

            }
        });

    }
}
