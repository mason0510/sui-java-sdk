package com.github.wubuku.sui.bean;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class GenericAuthoritySignatureDeserializer extends JsonDeserializer<GenericAuthoritySignature> {
    @Override
    public GenericAuthoritySignature deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {
        //todo
        return null;
    }
}