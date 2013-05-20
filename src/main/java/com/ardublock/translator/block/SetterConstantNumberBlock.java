package com.ardublock.translator.block;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.exception.SocketNullException;

public class SetterConstantNumberBlock extends TranslatorBlock {

	protected SetterConstantNumberBlock(Long blockId, Translator translator,
			String codePrefix, String codeSuffix, String label) {
		super(blockId, translator, codePrefix, codeSuffix, label);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toCode() throws SocketNullException {


		String varName = this.getRequiredTranslatorBlockAtSocket(0).toCode();
		String constVal = this.getRequiredTranslatorBlockAtSocket(1).toCode();
		

		String setupCode = varName + " = " +constVal+";";
		translator.addSetupCommand(setupCode);
		return "";
	}

}
