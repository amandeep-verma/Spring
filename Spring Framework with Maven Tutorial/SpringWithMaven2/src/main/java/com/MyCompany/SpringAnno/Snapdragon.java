package com.MyCompany.SpringAnno;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// The default id is non qualified and de-capitalized class name.
@Component
// primary tag takes this class as default when we are creating of the object from interface.
@Primary
public class Snapdragon implements MobileProcessor{

	public void process() {
		System.out.println("World's best CPU");

	}
}
