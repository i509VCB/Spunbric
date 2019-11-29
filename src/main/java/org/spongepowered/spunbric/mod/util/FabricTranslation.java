package org.spongepowered.spunbric.mod.util;

import net.minecraft.client.resource.language.I18n;
import org.spongepowered.api.text.translation.Translation;

import java.util.Locale;

//TODO: support multiple locales at once?
public class FabricTranslation implements Translation {
	private String id;

	public FabricTranslation(String id) {
		this.id = id;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String get(Locale locale) {
		return I18n.translate(id);
	}

	@Override
	public String get(Locale locale, Object... args) {
		return I18n.translate(id, args);
	}
}
