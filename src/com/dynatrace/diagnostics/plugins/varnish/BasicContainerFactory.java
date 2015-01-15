package com.dynatrace.diagnostics.plugins.varnish;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ContainerFactory;

public class BasicContainerFactory implements ContainerFactory {
        
        @Override
        public List<?> creatArrayContainer() {
                return new LinkedList();
        }

        @Override
        public Map<?, ?> createObjectContainer() {
                return new HashMap();
        }

}