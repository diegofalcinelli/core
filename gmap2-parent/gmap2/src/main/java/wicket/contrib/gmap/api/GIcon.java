/*
 * $Id$
 * $Revision$
 * $Date$
 * 
 * ==============================================================================
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package wicket.contrib.gmap.api;


/**
 * Represents an Google Maps API's
 * http://code.google.com/apis/maps/documentation/reference.html#GIcon
 * 
 * @author Robert Jacolin, Gregory Maes, Vincent Demay, Anyware Technologies
 */
public class GIcon implements GValue, Cloneable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1714038753187423501L;

	private String image = "http://www.google.com/mapfiles/marker.png";
	private String shadow = "http://www.google.com/mapfiles/shadow50.png";
	private GSize iconSize = null;
	private GSize shadowSize = null;
	private GPoint iconAnchor = null;
	private GPoint infoWindowAnchor = null;
	private GPoint infoShadowAnchor = null;

	public GIcon()
	{
	}

	public GIcon(String image)
	{
		this.image = image;
	}

	public GIcon(String image, String shadow)
	{
		this.image = image;
		this.shadow = shadow;
	}

	public GIcon(String image, String shadow, GSize iconSize, GSize shadowSize, GPoint iconAnchor, GPoint infoWindowAnchor, GPoint infoShadowAnchor)
	{
		this.image = image;
		this.shadow = shadow;
		this.iconSize = iconSize;
		this.shadowSize = shadowSize;
		this.iconAnchor = iconAnchor;
		this.infoWindowAnchor = infoWindowAnchor;
		this.infoShadowAnchor = infoShadowAnchor;
	}

	public String getId()
	{
		return "icon" + String.valueOf(System.identityHashCode(this));
	}

	public String getImage()
	{
		return image;
	}

	public String getShadow()
	{
		return shadow;
	}

	public GSize getIconSize()
	{
		return iconSize;
	}

	public GSize getShadowSize()
	{
		return this.shadowSize;
	}

	public GPoint getIconAnchor()
	{
		return this.iconAnchor;
	}

	public GPoint getInfoWindowAnchor()
	{
		return this.infoWindowAnchor;
	}

	public GPoint getInfoShadowAnchor()
	{
		return this.infoShadowAnchor;
	}

	public String getJSconstructor()
	{
		StringBuffer buffer = new StringBuffer();
		buffer.append("(function() {\n");
		buffer.append("var icon = new GIcon();\n");
		buffer.append("icon.image = \"").append(image).append("\";\n");
		buffer.append("icon.shadow = \"").append(shadow).append("\";\n");

		if (iconSize != null)
		{
			buffer.append("icon.iconSize = ").append(iconSize.getJSconstructor()).append(";\n");
		}

		if (shadowSize != null)
		{
			buffer.append("icon.shadowSize = ").append(shadowSize.getJSconstructor()).append(";\n");
		}

		if (iconAnchor != null)
		{
			buffer.append("icon.iconAnchor = ").append(iconAnchor.getJSconstructor()).append(";\n");
		}

		if (infoWindowAnchor != null)
		{
			buffer.append("icon.infoWindowAnchor = ").append(infoWindowAnchor.getJSconstructor()).append(";\n");
		}

		if (infoShadowAnchor != null)
		{
			buffer.append("icon.infoShadowAnchor = ").append(infoShadowAnchor.getJSconstructor()).append(";\n");
		}

		buffer.append("return icon;\n");
		buffer.append("})()\n");
		return buffer.toString();
	}

	@Override
	public int hashCode()
	{
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + ((iconAnchor == null) ? 0 : iconAnchor.hashCode());
		result = PRIME * result + ((iconSize == null) ? 0 : iconSize.hashCode());
		result = PRIME * result + ((image == null) ? 0 : image.hashCode());
		result = PRIME * result + ((infoShadowAnchor == null) ? 0 : infoShadowAnchor.hashCode());
		result = PRIME * result + ((infoWindowAnchor == null) ? 0 : infoWindowAnchor.hashCode());
		result = PRIME * result + ((shadow == null) ? 0 : shadow.hashCode());
		result = PRIME * result + ((shadowSize == null) ? 0 : shadowSize.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final GIcon other = (GIcon)obj;
		if (iconAnchor == null)
		{
			if (other.iconAnchor != null)
				return false;
		}
		else if (!iconAnchor.equals(other.iconAnchor))
			return false;
		if (iconSize == null)
		{
			if (other.iconSize != null)
				return false;
		}
		else if (!iconSize.equals(other.iconSize))
			return false;
		if (image == null)
		{
			if (other.image != null)
				return false;
		}
		else if (!image.equals(other.image))
			return false;
		if (infoShadowAnchor == null)
		{
			if (other.infoShadowAnchor != null)
				return false;
		}
		else if (!infoShadowAnchor.equals(other.infoShadowAnchor))
			return false;
		if (infoWindowAnchor == null)
		{
			if (other.infoWindowAnchor != null)
				return false;
		}
		else if (!infoWindowAnchor.equals(other.infoWindowAnchor))
			return false;
		if (shadow == null)
		{
			if (other.shadow != null)
				return false;
		}
		else if (!shadow.equals(other.shadow))
			return false;
		if (shadowSize == null)
		{
			if (other.shadowSize != null)
				return false;
		}
		else if (!shadowSize.equals(other.shadowSize))
			return false;
		return true;
	}

	public GIcon clone() {
		try
		{
			return (GIcon)super.clone();
		}
		catch (CloneNotSupportedException e)
		{
			throw new Error(e);
		}
	}

	public GIcon iconSize(GSize iconSize)
	{
		GIcon clone = clone();
		clone.iconSize = iconSize;
		return clone;
	}

	public GIcon shadowSize(GSize shadowSize)
	{
		GIcon clone = clone();
		clone.shadowSize = shadowSize;
		return clone;
	}

	public GIcon iconAnchor(GPoint iconAnchor)
	{
		GIcon clone = clone();
		clone.iconAnchor = iconAnchor;
		return clone;
	}

	public GIcon infoWindowAnchor(GPoint infoWindowAnchor)
	{
		GIcon clone = clone();
		clone.infoWindowAnchor = infoWindowAnchor;
		return clone;
	}

	public GIcon infoShadowAnchor(GPoint infoShadowAnchor)
	{
		GIcon clone = clone();
		clone.infoShadowAnchor = infoShadowAnchor;
		return clone;
	}	
}