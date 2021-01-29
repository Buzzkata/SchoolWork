void Array::push_back(const element_type & val) {

    if (num_elements == max_cap) {

        resize();

    }

    data[num_elements] = val;

    ++num_elements;

}



void Array::pop_back() {

    if (num_elements >= 1) {

        data[num_elements] = NULL;

        --num_elements;

    }

}



void Array::push_front(const element_type & val) {

    if (num_elements == max_cap) {

        resize();

    }

    double *temp = new double[num_elements];

    for (size_type i = 0; i < num_elements; i++) {

        temp[i] = data[i];

    }

    data[0] = val;

    num_elements++;

    for (size_type j = 1; j < num_elements; j++) {

        data[j] = temp[j - 1];

    }

    

    

}



void Array::pop_front() {

    if (num_elements >= 1) {

        data[0] = NULL;

        if (num_elements > 1) {

            for(size_type i = 0; i < num_elements; i++)

                data[i] = data[i + 1];

        }

        num_elements--;

    }

}



void Array::shrink_to_size() {

    max_cap = num_elements;

}



Array::element_type & Array::at( size_type index ) {

    if (index < 0 || index >= num_elements) {

        throw std::invalid_argument("Error: invalid index!");

    }

    else {

        return data[index];

    }

}



Array::element_type & Array::operator[]( size_type idx ) {

    if (idx < 0 || idx > num_elements) {

        std::invalid_argument("Error: invalid index!");

    }

    else {

        return data[idx];

    }

}



Array::element_type Array::operator[]( size_type idx ) const {

    if (idx < 0 || idx > num_elements) {

        std::invalid_argument("Error: invalid index!");

    }

    else {

        return data[idx];

    }

}



void Array::resize() {

    max_cap <<= 1; // Doubles capacity

    

    // now we resize the array, copying the data over

    element_type *new_data = new element_type[max_cap];

    for ( size_type idx = 0; idx < num_elements; ++idx ) {

        new_data[idx] = data[idx];

    }

    delete[] data;

    data = new_data;

}



std::ostream & operator<<( std::ostream & os, const Array & arr ) {

    os << '[';

    if ( arr.num_elements > 0 ) {

        for ( Array::size_type idx = 0; idx < arr.num_elements - 1; ++idx ) {

            os << arr[idx] << ',';

        }

        os << arr[arr.num_elements - 1];

    }

    os << ']';

    

    return os;

}





/* #include "Array.h"



Array::Array( size_type initial ) : num_elements( 0 ), max_cap( initial ), data( new element_type[initial] ) {}



Array::Array( const Array & other ) {

	this->max_cap = other.max_cap;

	this->num_elements = other.num_elements;

	this->data = new element_type[max_cap];

	for ( size_type idx = 0; idx < num_elements; ++idx ) {

		this->data[idx] = other.data[idx];

	}

}



void Array::reserve( size_type new_size ) {

	if ( new_size <= max_cap )

		return;



	while ( max_cap < new_size ) {

		resize();

	}

}



Array::element_type & Array::operator[]( size_type idx ) {

    if(idx < 0 || idx > num_elements)

        throw("Exception");

    else

        return data[idx];

}



Array::element_type Array::operator[]( size_type idx ) const {

    if(idx < 0 || idx > num_elements)

        throw("Exception");

    else

        return data[idx];

}



void Array::resize() {

	max_cap <<= 1; // Doubles capacity



	// now we resize the array, copying the data over

	element_type *new_data = new element_type[max_cap];

	for ( size_type idx = 0; idx < num_elements; ++idx ) {

		new_data[idx] = data[idx];

	}

	delete[] data;

	data = new_data;

}



std::ostream & operator<<( std::ostream & os, const Array & arr ) {

	os << '[';

	if ( arr.num_elements > 0 ) {

		for ( Array::size_type idx = 0; idx < arr.num_elements - 1; ++idx ) {

			os << arr[idx] << ',';

		}

		os << arr[arr.num_elements - 1];

	}

	os << ']';



	return os;

}



void Array::push_back(const element_type val){

    if(num_elements == max_cap)

        resize();

    data[num_elements] = val;

}



void Array::pop_back(){

    if(num_elements != 0)

        num_elements--;

}



void Array::push_front(const element_type val){

    

    if(num_elements == max_cap){

        resize();

    }

    double *temp = new double[num_elements];

    for(size_type i =0; i < num_elements; i++){

        temp[i] = data[i];

    }

    data[0] = val;

    num_elements++;

    for(size_type j = 1; j < num_elements; j++){

        data[j] = temp[j - 1];

    }

}



void Array::pop_front(){

    if(num_elements >= 1){

        data[0] = 0;

        if(num_elements > 1){

            for(size_type i = 0; i < num_elements; i++)

                data[i] = data[i + 1];

        }

        num_elements--;

    }

    }



    /*

    if(num_elements != 0)

    int j = num_elements - 1;

    int i = num_elements - 1;

    for(i; i < 0; i--){

        j--;

    data[j] = data[i];

    }

 





void Array::shrink_to_fit(){

    while(max_cap > num_elements)

        max_cap--;

}

 */