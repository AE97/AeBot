package net.ae97.pokebot.extensions.dxdiag.download;

import nu.xom.Element;

import java.util.ArrayList;

/**
 * UrielSalads Copyright (C) 2016 Uriel Salischiker
 * <p>
 * This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public
 * License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * <p>
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */
public class Nvidia {

    public static class Series {

        public int id;

        public Series(Element lookupValue) {
            id = Integer.parseInt(lookupValue.getFirstChildElement("Value").getValue());
        }

        public static class Product {
            public String name;
            public int id;

            public ArrayList<OS> os;

            public Product(Element lookupValue) {
                name = lookupValue.getFirstChildElement("Name").getValue();
                id = Integer.parseInt(lookupValue.getFirstChildElement("Value").getValue());
                os = new ArrayList<>();
            }

            public static class OS {
                private String code;
                private String name;
                public int id;
                public boolean is64;
                public String minified = null;
                public String downloadLink;
                public boolean shouldDownload = false;

                public OS(Element lookupValue) {
                    code = lookupValue.getAttribute("Code").getValue();
                    name = lookupValue.getFirstChildElement("Name").getValue();
                    id = Integer.parseInt(lookupValue.getFirstChildElement("Value").getValue());
                    if (code.startsWith("10.0")) {
                        minified = "10";
                    } else if (code.startsWith("6.3")) {
                        minified = "8.1";
                    } else if (code.startsWith("6.2")) {
                        minified = "8";
                    } else if (code.startsWith("6.1")) {
                        minified = "7";
                    } else if (code.startsWith("6.0")) {
                        minified = "Vista";
                    } else if (code.startsWith("5.1")) {
                        minified = "XP";
                    }
                    is64 = !(name.contains("32") || !name.contains("64"));
                    shouldDownload = minified != null;
                }

            }
        }
    }
}
