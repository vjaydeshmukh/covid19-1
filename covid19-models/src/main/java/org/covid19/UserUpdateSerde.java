package org.covid19;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.Serializer;

import java.nio.charset.StandardCharsets;

public class UserUpdateSerde extends Serdes.WrapperSerde<UserUpdate> {
    public UserUpdateSerde() {
        super(new Serializer<UserUpdate>() {
            private Gson gson = new GsonBuilder().serializeNulls().create();

            @Override
            public byte[] serialize(String s, UserUpdate userUpdate) {
                return gson.toJson(userUpdate).getBytes(StandardCharsets.UTF_8);
            }
        }, new Deserializer<UserUpdate>() {
            private Gson gson = new Gson();

            @Override
            public UserUpdate deserialize(String s, byte[] bytes) {
                return gson.fromJson(new String(bytes), UserUpdate.class);
            }
        });
    }
}
