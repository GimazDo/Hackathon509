package com.gimaz.hackathon.blockchain;

import org.web3j.abi.datatypes.AbiTypes;
import org.web3j.abi.datatypes.StaticArray;
import org.web3j.abi.datatypes.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StaticStruct extends StaticArray<Type> implements StructType {

    private final List<Class<Type>> itemTypes = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public StaticStruct(List<Type> values) {
        super(Type.class, values.size(), values);
        for (Type value : values) {
            itemTypes.add((Class<Type>) value.getClass());
        }
    }

    @SafeVarargs
    public StaticStruct(Type... values) {
        this(Arrays.asList(values));
    }

    @Override
    public String getTypeAsString() {
        final StringBuilder type = new StringBuilder("(");
        for (int i = 0; i < itemTypes.size(); ++i) {
            final Class<Type> cls = itemTypes.get(i);
            if (StructType.class.isAssignableFrom(cls)) {
                type.append(getValue().get(i).getTypeAsString());
            } else {
                type.append(AbiTypes.getTypeAString(cls));
            }
            if (i < itemTypes.size() - 1) {
                type.append(",");
            }
        }
        type.append(")");
        return type.toString();
    }
}