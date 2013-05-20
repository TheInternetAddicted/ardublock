package com.ardublock.translator.block;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.exception.SocketNullException;

public class TestBlock extends TranslatorBlock {

	

	protected TestBlock(Long blockId, Translator translator, String codePrefix,
			String codeSuffix, String label) {
		super(blockId, translator, codePrefix, codeSuffix, label);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toCode() throws SocketNullException {
		
					
		
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(1);
		String port = translatorBlock.toCode();
		
		translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
		String wait = translatorBlock.toCode();
		
		String ret =
				"digitalWrite("+port+" , HIGH);\n"+
				"delay("+wait+");\n"+
				"digitalWrite("+port+" , LOW" +");\n"+
				"delay("+wait+");\n";
				
		
		
		String setupCode = "pinMode( " + port + " , OUTPUT);";
		translator.addSetupCommand(setupCode);
		return ret;
	}

}
