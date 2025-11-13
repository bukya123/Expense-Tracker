
const products = [
    {
        
        productName: "H&M Hoddie",
        productDescription: "Best Hoddie for winters",
        price: 2000.0,
        quantity: 3000,
        image: "https://embarkx.com/sample/placeholder.png",
        discount: 10.0,
        specialPrice: 1800.0
      },
      {
        productName: "H&M Hoddie",
        productDescription: "Best Hoddie for winters",
        price: 2000.0,
        quantity: 3000,
        image: "https://embarkx.com/sample/placeholder.png",
        discount: 10.0,
        specialPrice: 1800.0
      },
      {
       productName: "H&M Hoddie",
        productDescription: "Best Hoddie for winters",
        price: 2000.0,
        quantity: 3000,
        image: "https://embarkx.com/sample/placeholder.png",
        discount: 10.0,
        specialPrice: 1800.0
      }
];

function AboutPage(){
    return (
        <div className="max-w-7xl mx-auto px-4 py-8">
            <h1 className="text-slate-800 text-4xl font-bold text-center mb-12">
                About Us
            </h1>
           <div className="flex flex-col lg:flex-row justify-between items-center mb-12">
                <div className="w-full md:w-1/2 text-center md:text-left">
                    <p className="text-lg mb-4">
                        Track every expense, conquer every cost
Automate business expense management to speed up back-office processes, reimburse employees faster, avoid costly errors, and more.
                    </p>
                </div>

                <div className="w-full md:w-1/2 mb-6 md:mb-0">
                    <img
                        src="https://embarkx.com/sample/placeholder.png"
                        alt="About Us"
                        className="w-full h-auto rounded-lg shadow-lg transform transition-transform duration-300 hover:scale-105"></img>
                </div>
           </div>


           <div className="py-7 space-y-8">
            {/* <h1 className="text-slate-800 text-4xl font-bold text-center">
                Our Partners
            </h1> */}
            {/* <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
               {products.map((product) => (
                <ProductCard 
                    item={product}
                    about={true}
                />
               ))
               }
                
            </div> */}
           </div>
        </div>
    )
}
export default AboutPage;