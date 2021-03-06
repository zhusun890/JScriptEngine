package site.misaka.luaj;

import org.luaj.vm2.LuaError;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;
import org.luaj.vm2.script.LuaScriptEngine;
import org.luaj.vm2.script.LuajContext;
import site.misaka.engine.PSREngineAdapter;

public class LuaJAdapter extends PSREngineAdapter<LuaScriptEngine> {
	public LuaJAdapter(LuaScriptEngine engine) {
		super(engine);
	}

	@Override
	public void invoke(String name, Object... args) {
		try {
			LuaValue func = ((LuajContext) this.engine.getContext()).globals.get(name);
			LuaValue[] luaArgs = new LuaValue[args.length];
			for (int i = 0; i < luaArgs.length; i++) {
				luaArgs[i] = CoerceJavaToLua.coerce(args[i]);
			}
			func.invoke(luaArgs);
		} catch (LuaError ignore) {

		}
	}
}
