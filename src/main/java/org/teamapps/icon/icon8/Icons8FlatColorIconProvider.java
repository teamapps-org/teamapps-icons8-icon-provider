package org.teamapps.icon.icon8;

import org.apache.commons.io.IOUtils;
import org.teamapps.icons.api.IconStyle;
import org.teamapps.icons.provider.SvgIconProvider;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

public class Icons8FlatColorIconProvider implements SvgIconProvider<IconStyle> {

	public static final String LIBRARY_ID = "icon8";

	private static final IconStyle ICON_STYLE = new IconStyle() {
		@Override
		public String getStyleId() {
			return "standard";
		}

		@Override
		public String getStyleName() {
			return null;
		}

		@Override
		public boolean canBeUsedAsSubIcon() {
			return true;
		}
	};
	private static final Set<IconStyle> STYLES = new HashSet<>();

	static { STYLES.add(ICON_STYLE);}

	public String getInnerSvg(IconStyle style, String s) {
		return null;
	}

	@Override
	public byte[] getIcon(String styleId, int size, String iconName) {
		String svg = getSVG(styleId, iconName);
		if (svg != null) {
			return svg.getBytes(StandardCharsets.UTF_8);
		} else {
			return null;
		}
	}

	private String getSVG(String styleId, String iconName) {
		if (!iconName.endsWith(".svg")) {
			iconName += ".svg";
		}


		InputStream inputStream = getClass().getResourceAsStream("/org/teamapps/icon/icon8/" + iconName);
		if (inputStream == null) {
			return null;
		}
		try {
			return IOUtils.toString(inputStream, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getIconLibraryId() {
		return LIBRARY_ID;
	}

	public Set<Integer> getAvailableIconSizes() {
		return null;
	}

	public Set<IconStyle> getAvailableIconStyles() {
		return STYLES;
	}

	public IconStyle getDefaultDesktopStyle() {
		return ICON_STYLE;
	}

	public IconStyle getDefaultMobileStyle() {
		return ICON_STYLE;
	}

	public IconStyle getDefaultSubIconStyle() {
		return ICON_STYLE;
	}
}
