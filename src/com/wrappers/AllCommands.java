package com.wrappers;

import java.util.PriorityQueue;
import java.util.Queue;

public class AllCommands {
    Queue<String> queue = new PriorityQueue<>();

    public AllCommands(){
        queue.add("add");
        queue.add("add_if_min");
        queue.add("clear");
        queue.add("count_by_hair_color");
        queue.add("execute_script");
        queue.add("exit");
        queue.add("filter_starts_with_name");
        queue.add("help");
        queue.add("history");
        queue.add("info");
        queue.add("print_unique_height");
        queue.add("remove_by_id");
        queue.add("remove_lower");
        queue.add("show");
        queue.add("update_by_id");
    }

    public Queue<String> getQueue(){
        return queue;
    }
}
