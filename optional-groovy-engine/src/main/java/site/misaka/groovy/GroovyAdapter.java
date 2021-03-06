package site.misaka.groovy;

import org.codehaus.groovy.jsr223.GroovyScriptEngineImpl;
import site.misaka.engine.PSREngineAdapter;

import javax.script.ScriptException;

public class GroovyAdapter extends PSREngineAdapter<GroovyScriptEngineImpl> {
	public GroovyAdapter(GroovyScriptEngineImpl engine) {
		super(engine);
	}

	@Override
	public void invoke(String name, Object... args) {
		try {
			this.engine.invokeFunction(name, args);
		} catch (ScriptException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException ignore) {

		}
	}
}
