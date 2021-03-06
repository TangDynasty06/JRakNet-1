/*
 *       _   _____            _      _   _          _   
 *      | | |  __ \          | |    | \ | |        | |  
 *      | | | |__) |   __ _  | | __ |  \| |   ___  | |_ 
 *  _   | | |  _  /   / _` | | |/ / | . ` |  / _ \ | __|
 * | |__| | | | \ \  | (_| | |   <  | |\  | |  __/ | |_ 
 *  \____/  |_|  \_\  \__,_| |_|\_\ |_| \_|  \___|  \__|
 *                                                  
 * The MIT License (MIT)
 *
 * Copyright (c) 2016, 2017 MarfGamer
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.  
 */
package net.marfgamer.jraknet.util.map;

import java.util.HashMap;
import java.util.Map;

public class ByteMap<T> extends HashMap<Byte, T> implements Map<Byte, T>, DynamicKey<Byte> {

	private static final long serialVersionUID = 4324132003573381634L;

	public boolean containsKey(byte key) {
		return super.containsKey(new Byte(key));
	}

	public boolean containsValue(Object value) {
		return super.containsValue(value);
	}

	public T get(byte key) {
		return super.get(new Byte(key));
	}

	public T put(byte key, T value) {
		return super.put(new Byte(key), value);
	}

	public T remove(byte key) {
		return super.remove(new Byte(key));
	}

	@Override
	public void renameKey(Byte oldKey, Byte newKey) throws NullPointerException {
		T storedObject = this.remove(oldKey.byteValue());
		if (storedObject == null) {
			throw new NullPointerException();
		}
		this.put(newKey.byteValue(), storedObject);
	}

}
