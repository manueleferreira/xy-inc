package br.com.xyinc.repository;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by manuele on 22/10/17.
 */
public class JsonUtil {

    public static byte[] toJson(Object r) throws Exception {
        ObjectMapper map = new ObjectMapper();
        return map.writeValueAsString(r).getBytes();
    }
}
