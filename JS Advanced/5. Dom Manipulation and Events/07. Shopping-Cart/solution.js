function solve() {
   const textArea = document.getElementsByTagName('textarea')[0];
   const initialCart = document.getElementsByClassName('shopping-cart')[0];
   initialCart.addEventListener('click',onClick);
   initialCart.getElementsByClassName('checkout')[0].addEventListener('click',listTotal);

   let cart = new Map();
   
   function onClick (ev){
      if(ev.target.className == 'add-product' && ev.target.tagName=='BUTTON'){
         const product = ev.target.parentNode.parentNode;
         const title = product.getElementsByClassName('product-title')[0].textContent;
         const price = Number(product.getElementsByClassName('product-line-price')[0].textContent);
         if (cart.has(title)){
            cart.set(title,cart.get(title)+price);
         } else {
            cart.set(title,price);
         }
         textArea.textContent += `Added ${title} for ${price.toFixed(2)} to the cart.\n`
      }
   }

   function listTotal(ev){
      const list = Array.from(cart.keys()).join(', ');
      const totalPrice = Array.from(cart.values()).reduce((acc,c)=>acc+Number(c),0);
      textArea.textContent+=`You bought ${list} for ${totalPrice.toFixed(2)}.`
      initialCart.removeEventListener('click',onClick);
      initialCart.getElementsByClassName('checkout')[0].removeEventListener('click',listTotal)
   }

}