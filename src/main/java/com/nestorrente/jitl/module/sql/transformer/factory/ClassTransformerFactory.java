package com.nestorrente.jitl.module.sql.transformer.factory;

import com.google.common.reflect.TypeToken;
import com.nestorrente.jitl.module.sql.SQLModule;
import com.nestorrente.jitl.module.sql.transformer.ResultSetTransformer;

public class ClassTransformerFactory<T> implements ResultSetTransformerFactory {

	private final Class<T> type;
	private final ResultSetTransformer<? extends T> transformer;

	public ClassTransformerFactory(Class<T> type, ResultSetTransformer<? extends T> transformer) {
		this.type = type;
		this.transformer = transformer;
	}

	@Override
	public ResultSetTransformer<?> get(SQLModule module, TypeToken<?> type) {
		return this.type.equals(type.getRawType()) ? this.transformer : null;
	}

}
