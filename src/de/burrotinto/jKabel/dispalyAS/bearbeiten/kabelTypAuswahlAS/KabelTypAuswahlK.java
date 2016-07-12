/*
 * jKabel - Ein hochperfomantes, extremstanpassungsfähiges Mehrbenutzersystem zur erfassung von Kabelstrecken
 *
 * Copyright (C) 2016 Florian Klinger
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package de.burrotinto.jKabel.dispalyAS.bearbeiten.kabelTypAuswahlAS;

import de.burrotinto.jKabel.dbauswahlAS.IDBWrapper;
import de.burrotinto.jKabel.dbauswahlAS.enitys.IKabeltypE;

import java.util.List;

/**
 * Created by derduke on 21.05.16.
 */
class KabelTypAuswahlK {
    public final IDBWrapper db;

    public KabelTypAuswahlK(IDBWrapper db) {
        this.db = db;
    }

    public List<IKabeltypE> getTypen() {

        return db.getAllKabeltypen();
    }

    public IKabeltypE getTyp(Integer integer) {
        for (IKabeltypE k : db.getAllKabeltypen()) {
            if (k.getMaterialNummer() == integer) {
                return k;
            }
        }
        return null;
    }
}

