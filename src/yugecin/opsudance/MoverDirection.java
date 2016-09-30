/*
 * opsu!dance - fork of opsu! with cursordance auto
 * Copyright (C) 2016 yugecin
 *
 * opsu!dance is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * opsu!dance is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with opsu!dance.  If not, see <http://www.gnu.org/licenses/>.
 */
package yugecin.opsudance;

import java.util.Random;

public enum MoverDirection {

	LEFT ("Left", 0) {
		@Override
		public int getDirection(int currentDirection) {
			return 1;
		}
	},
	RIGHT ("Right", 1) {
		@Override
		public int getDirection(int currentDirection) {
			return 0;
		}
	},
	ALTERNATE ("Alternate", 2) {
		@Override
		public int getDirection(int currentDirection) {
			return currentDirection * -1;
		}
	},
	RANDOM ("Random", 3) {
		@Override
		public int getDirection(int currentDirection) {
			if (rand.nextInt(2) == 1) {
				return currentDirection * -1;
			}
			return currentDirection;
		}
	};

	public String displayName;
	private int nr;

	private static Random rand;

	MoverDirection(String displayName, int nr) {
		this.displayName = displayName;
		this.nr = nr;
	}

	public static void reset(String mapName) {
		rand = new Random(mapName.hashCode());
	}

	public abstract int getDirection(int currentDirection);

}
