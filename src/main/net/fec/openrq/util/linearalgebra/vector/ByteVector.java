/*
 * Copyright 2014 Jose Lopes
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/*
 * Copyright 2011-2013, by Vladimir Kostyukov and Contributors.
 * 
 * This file is part of la4j project (http://la4j.org)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * Contributor(s): Daniel Renshaw
 * Jakob Moellers
 * Maxim Samoylov
 * Miron Aseev
 */
package net.fec.openrq.util.linearalgebra.vector;


import java.io.Externalizable;

import net.fec.openrq.util.linearalgebra.factory.Factory;
import net.fec.openrq.util.linearalgebra.matrix.ByteMatrix;
import net.fec.openrq.util.linearalgebra.vector.functor.VectorAccumulator;
import net.fec.openrq.util.linearalgebra.vector.functor.VectorFunction;
import net.fec.openrq.util.linearalgebra.vector.functor.VectorPredicate;
import net.fec.openrq.util.linearalgebra.vector.functor.VectorProcedure;


/**
 * The byte vector interface.
 */
public interface ByteVector extends Externalizable {

    /**
     * Gets the specified element of this vector.
     * 
     * @param i
     *            element's index
     * @return the element of this vector
     */
    byte get(int i);

    /**
     * Sets the specified element of this matrix to given {@code value}.
     * 
     * @param i
     *            element's index
     * @param value
     *            element's new value
     */
    void set(int i, byte value);

    /**
     * Assigns all elements of this vector to given {@code value}.
     * 
     * @param value
     *            the elements' new value
     */
    void assign(byte value);

    /**
     * Returns the length of this vector.
     * 
     * @return length of this vector
     */
    int length();

    /**
     * Adds given {@code value} (v) to this vector (X).
     * 
     * @param value
     *            the right hand value for addition
     * @return X + v
     */
    ByteVector add(byte value);

    /**
     * Adds given {@code value} (v) to this vector (X).
     * 
     * @param value
     *            the right hand value for addition
     * @param factory
     *            the factory of result vector
     * @return X + v
     */
    ByteVector add(byte value, Factory factory);

    /**
     * Adds given {@code vector} (X) to this vector (Y).
     * 
     * @param vector
     *            the right hand vector for addition
     * @return X + Y
     */
    ByteVector add(ByteVector vector);

    /**
     * Adds given {@code vector} (X) to this vector (Y).
     * 
     * @param vector
     *            the right hand vector for addition
     * @param factory
     *            the factory of result vector
     * @return X + Y
     */
    ByteVector add(ByteVector vector, Factory factory);

    /**
     * Multiplies this vector (X) by given {@code value} (v).
     * 
     * @param value
     *            the right hand value for multiplication
     * @return X * v
     */
    ByteVector multiply(byte value);

    /**
     * Multiplies this vector (X) by given {@code value} (v).
     * 
     * @param value
     *            the right hand value for multiplication
     * @param factory
     *            the factory of result vector
     * @return X * v
     */
    ByteVector multiply(byte value, Factory factory);

    /**
     * Calculates the Hadamard (element-wise) product of this vector and given {@code vector}.
     * 
     * @param vector
     *            the right hand vector for Hadamard product
     * @return the Hadamard product of two vectors
     */
    ByteVector hadamardProduct(ByteVector vector);

    /**
     * Calculates the Hadamard (element-wise) product of this vector and given {@code vector}.
     * 
     * @param vector
     *            the right hand vector for Hadamard product
     * @param factory
     *            the factory of result vector
     * @return the Hadamard product of two vectors
     */
    ByteVector hadamardProduct(ByteVector vector, Factory factory);

    /**
     * Multiples this vector (X) by given {@code matrix} (A).
     * 
     * @param matrix
     *            the right hand matrix for multiplication
     * @return X * A
     */
    ByteVector multiply(ByteMatrix matrix);

    /**
     * Multiples this vector (X) by given {@code matrix} (A).
     * 
     * @param matrix
     *            the right hand matrix for multiplication
     * @param factory
     *            the factory of result vector
     * @return X * A
     */
    ByteVector multiply(ByteMatrix matrix, Factory factory);

    /**
     * Subtracts given {@code value} (v) from this vector (X).
     * 
     * @param value
     *            the right hand value for subtraction
     * @return X - v
     */
    ByteVector subtract(byte value);

    /**
     * Subtracts given {@code value} (v) from this vector (X).
     * 
     * @param value
     *            the right hand value for subtraction
     * @param factory
     *            the factory of result vector
     * @return X - v
     */
    ByteVector subtract(byte value, Factory factory);

    /**
     * Subtracts given {@code vector} (Y) from this vector (X).
     * 
     * @param vector
     *            the right hand vector for subtraction
     * @return X - Y
     */
    ByteVector subtract(ByteVector vector);

    /**
     * Subtracts given {@code vector} (Y) from this vector (X).
     * 
     * @param vector
     *            the right hand vector for subtraction
     * @param factory
     *            the factory of result vector
     * @return X - Y
     */
    ByteVector subtract(ByteVector vector, Factory factory);

    /**
     * Divides this vector (X) by given {@code value} (v).
     * 
     * @param value
     *            the right hand value for division
     * @return X / v
     */
    ByteVector divide(byte value);

    /**
     * Divides this vector (X) by given {@code value} (v).
     * 
     * @param value
     *            the right hand value for division
     * @param factory
     *            the factory of result vector
     * @return X / v
     */
    ByteVector divide(byte value, Factory factory);

    /**
     * Multiplies up all elements of this vector.
     * 
     * @return product of all elements of this vector
     */
    byte product();

    /**
     * Summarizes all elements of the vector
     * 
     * @return sum of all elements of the vector
     */
    byte sum();

    /**
     * Swaps the specified elements of this vector.
     * 
     * @param i
     *            element's index
     * @param j
     *            element's index
     */
    void swap(int i, int j);

    /**
     * Creates a blank (an empty vector with same length) copy of this vector.
     * 
     * @return blank vector
     */
    ByteVector blank();

    /**
     * Creates a blank (an empty vector with same length) copy of this vector.
     * 
     * @param factory
     *            the factory of result vector
     * @return blank vector
     */
    ByteVector blank(Factory factory);

    /**
     * Copies this vector.
     * 
     * @return the copy of this vector
     */
    ByteVector copy();

    /**
     * Copies this vector.
     * 
     * @param factory
     *            the factory of result vector
     * @return the copy of this vector
     */
    ByteVector copy(Factory factory);

    /**
     * Copies this vector into the new vector with specified {@code length}.
     * 
     * @param length
     *            the length of new vector
     * @return the copy of this vector with new length
     */
    ByteVector resize(int length);

    /**
     * Copies this vector into the new vector with specified {@code length}.
     * 
     * @param length
     *            the length of new vector
     * @param factory
     *            the factory of result vector
     * @return the copy of this vector with new length
     */
    ByteVector resize(int length, Factory factory);

    /**
     * Shuffles this vector.
     * <p>
     * Copies this vector in the new vector that contains the same elements but with the elements shuffled around (which
     * might also result in the same vector (all outcomes are equally probable)).
     * </p>
     * 
     * @return the shuffled vector
     */
    ByteVector shuffle();

    /**
     * Shuffles this vector.
     * <p>
     * Copies this vector in the new vector that contains the same elements but with the elements shuffled around (which
     * might also result in the same vector (all outcomes are equally probable)).
     * </p>
     * 
     * @param factory
     *            the factory of result vector
     * @return the shuffled vector
     */
    ByteVector shuffle(Factory factory);

    /**
     * Retrieves the specified sub-vector of this vector. The sub-vector is specified by
     * interval of indices.
     * 
     * @param from
     *            the beginning of indices interval
     * @param until
     *            the ending of indices interval
     * @return the sub-vector of this vector
     */
    ByteVector slice(int from, int until);

    /**
     * Retrieves the specified sub-vector of this vector. The sub-vector is specified by
     * interval of indices.
     * 
     * @param from
     *            the beginning of indices interval
     * @param until
     *            the ending of indices interval
     * @param factory
     *            the factory of result vector
     * @return the sub-vector of this vector
     */
    ByteVector slice(int from, int until, Factory factory);

    /**
     * Retrieves the specified sub-vector of this vector. The sub-vector is specified by
     * interval of indices. The left point of interval is fixed to zero.
     * 
     * @param until
     *            the ending of indices interval
     * @return the sub-vector of this vector
     */
    ByteVector sliceLeft(int until);

    /**
     * Retrieves the specified sub-vector of this vector. The sub-vector is specified by
     * interval of indices. The left point of interval is fixed to zero.
     * 
     * @param until
     *            the ending of indices interval
     * @param factory
     *            the factory of result vector
     * @return the sub-vector of this vector
     */
    ByteVector sliceLeft(int until, Factory factory);

    /**
     * Retrieves the specified sub-vector of this vector. The sub-vector is specified by
     * interval of indices. The right point of interval is fixed to vector's length.
     * 
     * @param from
     *            the beginning of indices interval
     * @return the sub-vector of this vector
     */
    ByteVector sliceRight(int from);

    /**
     * Retrieves the specified sub-vector of this vector. The sub-vector is specified by
     * interval of indices. The right point of interval is fixed to vector's length.
     * 
     * @param from
     *            the beginning of indices interval
     * @param factory
     *            the factory of result vector
     * @return the sub-vector of this vector
     */
    ByteVector sliceRight(int from, Factory factory);

    /**
     * Returns a new vector with the selected elements.
     * 
     * @param indices
     *            the array of indices
     * @return the new vector with the selected elements
     */
    public ByteVector select(int[] indices);

    /**
     * Returns a new vector with the selected elements.
     * 
     * @param indices
     *            the array of indices
     * @param factory
     *            the factory of result vector
     * @return the new vector with the selected elements
     */
    public ByteVector select(int[] indices, Factory factory);

    /**
     * Returns the factory of this vector.
     * 
     * @return the factory of this vector
     */
    Factory factory();

    /**
     * Applies given {@code procedure} to each element of this vector.
     * 
     * @param procedure
     *            the vector procedure
     */
    void each(VectorProcedure procedure);

    /**
     * Applies given {@code procedure} to each non-zero element of this vector.
     * 
     * @param procedure
     *            the vector procedure
     */
    void eachNonZero(VectorProcedure procedure);

    /**
     * Searches for the maximum value of the elements of this vector.
     * 
     * @return the maximum value of this vector
     */
    byte max();

    /**
     * Searches for the minimum value of the elements of this vector.
     * 
     * @return the minimum value of this vector
     */
    byte min();

    /**
     * Builds a new vector by applying given {@code function} to each element
     * of this vector.
     * 
     * @param function
     *            the vector function
     * @return the transformed vector
     */
    ByteVector transform(VectorFunction function);

    /**
     * Builds a new vector by applying given {@code function} to each element
     * of this vector.
     * 
     * @param function
     *            the vector function
     * @param factory
     *            the factory of result vector
     * @return the transformed vector
     */
    ByteVector transform(VectorFunction function, Factory factory);

    /**
     * Builds a new vector by applying given {@code function} to the specified element
     * of this vector.
     * 
     * @param i
     *            element's index
     * @param function
     *            the vector function
     * @return the transformed vector
     */
    ByteVector transform(int i, VectorFunction function);

    /**
     * Builds a new vector by applying given {@code function} to the specified element
     * of this vector.
     * 
     * @param i
     *            element's index
     * @param function
     *            the vector function
     * @param factory
     *            the factory of result vector
     * @return the transformed vector
     */
    ByteVector transform(int i, VectorFunction function, Factory factory);

    /**
     * Updates all elements of this vector by applying given {@code function}.
     * 
     * @param function
     *            the the vector function
     */
    void update(VectorFunction function);

    /**
     * Updates all non zero elements of this vector by applying given {@code function}.
     * 
     * @param function
     *            the the vector function
     */
    void updateNonZeros(VectorFunction function);

    /**
     * Updates the specified element of this vector by applying given {@code function}.
     * 
     * @param i
     *            element's index
     * @param function
     *            the vector function
     */
    void update(int i, VectorFunction function);

    /**
     * Folds all elements of this vector with given {@code accumulator}.
     * 
     * @param accumulator
     *            the vector accumulator
     * @return the accumulated value
     */
    byte fold(VectorAccumulator accumulator);

    /**
     * Checks whether this vector compiles with given {@code predicate} or not.
     * 
     * @param predicate
     *            the vector predicate
     * @return whether this vector compiles with predicate
     */
    boolean is(VectorPredicate predicate);

    /**
     * Checks whether this vector compiles with given {@code predicate} or not.
     * 
     * @param predicate
     *            the vector predicate
     * @return whether this vector compiles with predicate
     */
    boolean non(VectorPredicate predicate);

    /**
     * Converts this vector to matrix with only one row.
     * 
     * @return the row matrix
     */
    ByteMatrix toRowMatrix();

    /**
     * Converts this vector to matrix with only one row.
     * 
     * @param factory
     *            the factory of result matrix
     * @return the row matrix
     */
    ByteMatrix toRowMatrix(Factory factory);

    /**
     * Converts this vector to matrix with only one column.
     * 
     * @return the column matrix
     */
    ByteMatrix toColumnMatrix();

    /**
     * Converts this vector to matrix with only one column.
     * 
     * @param factory
     *            the factory of result matrix
     * @return the column matrix
     */
    ByteMatrix toColumnMatrix(Factory factory);
}
