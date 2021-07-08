var canvas;
var gl;

window.onload = function init(){
    canvas = document.getElementById( "gl-canvas" );
    gl = canvas.getContext('webgl2');
    if ( !gl ) { alert( "WebGL 2.0 isn't available" ); }

    gl.viewport( 0, 0, canvas.width, canvas.height );
    gl.clearColor( 0, 0, 0, 1.0 );
    gl.clear( gl.COLOR_BUFFER_BIT );
	
	// 0.075 increments
    var sq1 = new Square([vec2( -0.45, -0.45 ),
						vec2(  -0.45,  0.45 ),
						vec2(  0.45, 0.45 ),
						vec2( 0.45, -0.45)]);
	
	var sq2 = new Square([vec2( -0.375, -0.375 ),
						vec2(  -0.375,  0.375 ),
						vec2(  0.375, 0.375 ),
						vec2( 0.375, -0.375)]);
						
	var sq3= new Square([vec2( -0.30, -0.30 ),
						vec2(  -0.30,  0.30 ),
						vec2(  0.30, 0.30 ),
						vec2( 0.30, -0.30)]);
						
	var sq4 = new Square([vec2( -0.225, -0.225 ),
						vec2(  -0.225,  0.225 ),
						vec2(  0.225, 0.225 ),
						vec2( 0.225, -0.225)]);
						
	var sq5 = new Square([vec2( -0.15, -0.15 ),
						vec2(  -0.15,  0.15 ),
						vec2(  0.15, 0.15 ),
						vec2( 0.15, -0.15)]);
						
	var sq6 = new Square([vec2( -0.075, -0.075 ),
						vec2(  -0.075,  0.075 ),
						vec2(  0.075, 0.075 ),
						vec2( 0.075, -0.075)]);
    sq1.drawWht();
	sq2.drawBlk();
	sq3.drawWht();
	sq4.drawBlk();
	sq5.drawWht();
	sq6.drawBlk();
	
	var tri = new Triangle();
	tri.draw();
	
	var cir = new Circle();
	cir.draw();
};

class Triangle{ 
    constructor(){

  		var vertices = [
    			vec2( -0.175, 0.70 ),
    			vec2(  0,  1 ), 
    			vec2(  0.175, 0.70 )
  		];
		
		var colors = [
				vec4( 0, 1, 0, 1 ),
    			vec4( 1, 0, 0, 1 ), 
    			vec4( 0, 0, 1, 1 )
		];
		
  		// Load the data into the GPU

  		this.vBufferId = gl.createBuffer();
  		gl.bindBuffer( gl.ARRAY_BUFFER, this.vBufferId );
  		gl.bufferData( gl.ARRAY_BUFFER, flatten(vertices), gl.STATIC_DRAW );
		
		this.vColorBufferId = gl.createBuffer();
  		gl.bindBuffer( gl.ARRAY_BUFFER, this.vColorBufferId );
  		gl.bufferData( gl.ARRAY_BUFFER, flatten(colors), gl.STATIC_DRAW );

  		// Get the location of the attribute and uniform variables from the shader program.
		this.shaderID = initShaders(gl, "vshader.glsl", "fshader.glsl");
  		this.aPositionID = gl.getAttribLocation( this.shaderID, "aPosition" );
  		this.aColorID = gl.getAttribLocation( this.shaderID, "aColor" );
  		
    }
    draw() {
        
        gl.useProgram( this.shaderID );
        
        //point the attributes to the buffer
        gl.bindBuffer( gl.ARRAY_BUFFER, this.vBufferId );
        gl.vertexAttribPointer( this.aPositionID, 2, gl.FLOAT, false, 0, 0 );
		
		gl.bindBuffer( gl.ARRAY_BUFFER, this.vColorBufferId );
        gl.vertexAttribPointer( this.aColorID, 4, gl.FLOAT, false, 0, 0 );

		//enable and draw!
		gl.enableVertexAttribArray(this.aPositionID );    
		gl.enableVertexAttribArray(this.aColorID );    
    	gl.drawArrays( gl.TRIANGLE_FAN, 0, 3 );
    	gl.disableVertexAttribArray(this.aPositionID );    
		gl.disableVertexAttribArray(this.aColorID );    
    }
}

class Square{ 
    constructor(vert){
 		// Four Vertices
  		var vertices = vert;

  		// Load the data into the GPU

  		this.vBufferId = gl.createBuffer();
  		gl.bindBuffer( gl.ARRAY_BUFFER, this.vBufferId );
  		gl.bufferData( gl.ARRAY_BUFFER, flatten(vertices), gl.STATIC_DRAW );

  		// Get the location of the attribute and uniform variables from the shader program.
		this.shaderID = initShaders(gl, "vshader_single.glsl", "fshader.glsl");
  		this.aPositionID = gl.getAttribLocation( this.shaderID, "aPosition" );
  		this.uColorID = gl.getUniformLocation( this.shaderID, "uColor" );
  		
    }
	
	drawWht() {
        
        gl.useProgram( this.shaderID );
        
        //point the attributes to the buffer
        gl.bindBuffer( gl.ARRAY_BUFFER, this.vBufferId );
        gl.vertexAttribPointer( this.aPositionID, 2, gl.FLOAT, false, 0, 0 );
		
		gl.uniform4fv(this.uColorID, vec4(1,1,1,1));

		//enable and draw!
		gl.enableVertexAttribArray(this.aPositionID );    
    	gl.drawArrays( gl.TRIANGLE_FAN, 0, 4 );
    	gl.disableVertexAttribArray(this.aPositionID );       
    }
	
	drawBlk() {
        
        gl.useProgram( this.shaderID );
        
        //point the attributes to the buffer
        gl.bindBuffer( gl.ARRAY_BUFFER, this.vBufferId );
        gl.vertexAttribPointer( this.aPositionID, 2, gl.FLOAT, false, 0, 0 );
		
		gl.uniform4fv(this.uColorID, vec4(0,0,0,1));

		//enable and draw!
		gl.enableVertexAttribArray(this.aPositionID );    
    	gl.drawArrays( gl.TRIANGLE_FAN, 0, 4 );
    	gl.disableVertexAttribArray(this.aPositionID );       
    }

}

class Circle{ 
    constructor(){
 		// loop to make verts
		var r = 0.5;
  		var vertices = [];
		for (let theta  = 0; theta <= (2*Math.PI); theta = theta + 0.1){
			var x = r * Math.cos(theta) + 0.5;
			var y = r * Math.sin(theta) + 0.5;
			vertices.push(vec2(x,y))
		}

  		// Load the data into the GPU

  		this.vBufferId = gl.createBuffer();
  		gl.bindBuffer( gl.ARRAY_BUFFER, this.vBufferId );
  		gl.bufferData( gl.ARRAY_BUFFER, flatten(vertices), gl.STATIC_DRAW );

  		// Get the location of the attribute and uniform variables from the shader program.
		this.shaderID = initShaders(gl, "vshader_single.glsl", "fshader.glsl");
  		this.aPositionID = gl.getAttribLocation( this.shaderID, "aPosition" );
  		this.uColorID = gl.getUniformLocation( this.shaderID, "uColor" );
  		
    }
	
	draw() {
        
        gl.useProgram( this.shaderID );
        
        //point the attributes to the buffer
        gl.bindBuffer( gl.ARRAY_BUFFER, this.vBufferId );
        gl.vertexAttribPointer( this.aPositionID, 2, gl.FLOAT, false, 0, 0 );
		
		gl.uniform4fv(this.uColorID, vec4(1,1,1,1));

		//enable and draw!
		gl.enableVertexAttribArray(this.aPositionID );    
    	gl.drawArrays( gl.TRIANGLE_FAN, 0, vertices.length );
    	gl.disableVertexAttribArray(this.aPositionID );       
    }

}

