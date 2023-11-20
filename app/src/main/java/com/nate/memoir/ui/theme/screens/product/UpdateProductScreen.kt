package com.nate.memoir.ui.theme.screens.product

import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.nate.memoir.R
import com.nate.memoir.data.productviewmodel
import com.nate.memoir.models.Product
import com.nate.memoir.navigation.ROUTE_VIEW_PRODUCT
import com.nate.memoir.navigation.ROUTE_VIEW_UPLOAD
import com.nate.memoir.ui.theme.BlueGray



@Composable
fun UpdateProductsScreen(navController: NavHostController, id: String) {




    Column(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(
            rememberScrollState()
        )
        .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally) {
        var context = LocalContext.current
        var name by remember { mutableStateOf("") }
        var quantity by remember { mutableStateOf("") }
        var price by remember { mutableStateOf("") }

        var currentDataRef = FirebaseDatabase.getInstance().getReference()
            .child("Uploads/$id")
        currentDataRef.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                var product = snapshot.getValue(Product::class.java)
                name = product!!.name
                quantity = product!!.quantity
                price = product!!.price
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        })

        Spacer(modifier = Modifier.height(18.dp))
        Image(
            painter = painterResource(R.drawable.mainlog),
            contentDescription = "image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(55.dp)
                .width(150.dp)
        )





        var productName by remember { mutableStateOf(TextFieldValue("")) }
        var productQuantity by remember { mutableStateOf(TextFieldValue("")) }
        var productPrice by remember { mutableStateOf(TextFieldValue("")) }


        Spacer(modifier = Modifier.height(20.dp))


        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = productName,
            onValueChange = { productName = it },
            label = { Text(text = "Update Memoir Description", color = Color.DarkGray) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))
        Spacer(modifier = Modifier.height(20.dp))



        ImagePickerU(Modifier,context, navController, productName.text.trim(), productQuantity.text.trim(), productPrice.text.trim(), id)


    }
}


@Composable
fun ImagePickerU(modifier: Modifier = Modifier, context: Context, navController: NavHostController, name:String, quantity:String, price:String, id: String) {


    var hasImage by remember { mutableStateOf(false) }
    var imageUri by remember { mutableStateOf<Uri?>(null) }





    val imagePicker = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri ->
            hasImage = uri != null
            imageUri = uri
        }
    )

    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {

        Card (modifier = Modifier
            .fillMaxWidth(0.70f)
            .padding(6.dp)
            .background(Color.Black).clickable { imagePicker.launch("image/*")  },
            shape = RoundedCornerShape(15.dp),

            ) {

            Box(
                modifier = Modifier
                    .height(160.dp)
                    .fillMaxSize()
                    .background(Color.Black)
            ) {

                if (hasImage && imageUri != null) {
                    val bitmap =
                        MediaStore.Images.Media.getBitmap(context.contentResolver, imageUri)
                    Image(
                        bitmap = bitmap.asImageBitmap(),
                        contentDescription = "Selected image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(232.dp)
                    )
                }
                else Image(painterResource(id = R.drawable.photomemoir_24 ), contentDescription = null, modifier = Modifier.size(232.dp))
            }
        }

        Spacer(modifier = Modifier.height(10.dp))


//        Button(
//            modifier = Modifier
//                .width(100.dp)
//                .height(40.dp),
//            onClick = { imagePicker.launch("image/*") },
//            colors = ButtonDefaults.buttonColors(
//                containerColor = BlueGray,
//                contentColor = Color.White
//            ), shape = RoundedCornerShape(size = 4.dp)) {
//
//            Icon(imageVector = Icons.Filled.Add, contentDescription = null, modifier = Modifier.size(13.dp))
//            Icon(imageVector = Icons.Filled.AccountBox, contentDescription = null)
//
//        }

        Spacer(modifier = Modifier.height(10.dp))




//        OutlinedTextField(
//            value = productName,
//            onValueChange = { productName = it },
//            label = { Text(text = "Memoir  Description", color = Color.DarkGray) },
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
//        )



        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = 15.dp), horizontalAlignment = Alignment.CenterHorizontally,) {



            Spacer(modifier = Modifier.height(10.dp))


            Button(
                modifier = Modifier
                    .width(270.dp)
                    .height(40.dp),
                onClick = { var productRepository = productviewmodel(navController,context)
                    productRepository.saveProductWithImage(name, quantity, price,imageUri!!)
                    navController.navigate(ROUTE_VIEW_UPLOAD) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = BlueGray,
                    contentColor = Color.White
                ), shape = RoundedCornerShape(size = 4.dp)) {

                Text(text = "Update Memoir", style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium))

            }

        }
    }
}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun UpdateProductsScreen(navController: NavHostController, id:String) {
//    Column(modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally) {
//        var context = LocalContext.current
//        var name by remember { mutableStateOf("") }
//        var quantity by remember { mutableStateOf("") }
//        var price by remember { mutableStateOf("") }
//
//        var currentDataRef = FirebaseDatabase.getInstance().getReference()
//            .child("Uploads/$id")
//        currentDataRef.addValueEventListener(object: ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                var product = snapshot.getValue(Product::class.java)
//                name = product!!.name
//                quantity = product!!.quantity
//                price = product!!.price
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
//            }
//        })
//
//        Spacer(modifier = Modifier.height(18.dp))
//        Image(
//            painter = painterResource(R.drawable.mainlog),
//            contentDescription = "image",
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .height(55.dp)
//                .width(150.dp)
//        )
//
//        var productName by remember { mutableStateOf(TextFieldValue(name)) }
//        var productQuantity by remember { mutableStateOf(TextFieldValue(quantity)) }
//        var productPrice by remember { mutableStateOf(TextFieldValue(price)) }
//
//        OutlinedTextField(
//            value = productName,
//            onValueChange = { productName = it },
//            label = { Text(text = "Update Memoir Description", color = Color.LightGray) },
//            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
//        )
//
//        Spacer(modifier = Modifier.height(20.dp))
//
////        OutlinedTextField(
////            value = productQuantity,
////            onValueChange = { productQuantity = it },
////            label = { Text(text = "Product Quantity - $quantity", color = Color.LightGray) },
////            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
////        )
//
//        Spacer(modifier = Modifier.height(20.dp))
//
////        OutlinedTextField(
////            value = productPrice,
////            onValueChange = { productPrice = it },
////            label = { Text(text = "Product Price - $price", color = Color.LightGray) },
////            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
////        )
//
//        Spacer(modifier = Modifier.height(20.dp))
//
////        Button(onClick = {
////            //-----------WRITE THE UPDATE LOGIC HERE---------------//
////            val productRepository = productviewmodel(navController, context)
////            var updatedProduct = mutableMapOf<String, Any>()
////            if (productName.text.trim().isNotEmpty()) {
////                updatedProduct["productName"] = productName.text.trim()
////            }
////            if (productQuantity.text.trim().isNotEmpty()) {
////                updatedProduct["productQuantity"] = productQuantity.text.trim()
////            }
////            if (productPrice.text.trim().isNotEmpty()) {
////                updatedProduct["productPrice"] = productPrice.text.trim()
////            }
////            productRepository.updateProduct(updatedProduct,id)
////            navController.navigate(ROUTE_VIEW_PRODUCT)
////        }, colors = ButtonDefaults.buttonColors(Color.Black)) {
////            Text(text = "Update", color = Color.White)
////        }
//
//
//
////        Button(onClick = {
////            //-----------WRITE THE UPDATE LOGIC HERE---------------//
////            var productRepository = productviewmodel(navController, context)
////            productRepository.updateProduct(productName.text.trim(),productQuantity.text.trim(),
////                productPrice.text.trim(), imageUrl = String(), id = String()
////            )
////
////            navController.navigate(ROUTE_VIEW_PRODUCT)
////
////
////        }, colors = ButtonDefaults.buttonColors(Color.Black)) {
////            Text(text = "Update Memoir", color = Color.White)
////        }
//
//        Button(
//            modifier = Modifier
//                .width(270.dp)
//                .height(40.dp),
//            onClick = { var productRepository = productviewmodel(navController, context)
//                productRepository.updateProduct(productName.text.trim(),productQuantity.text.trim(),
//                    productPrice.text.trim(), imageUrl = String(), id = String()
//                )
//
//                navController.navigate(ROUTE_VIEW_PRODUCT) },
//            colors = ButtonDefaults.buttonColors(
//                containerColor = BlueGray,
//                contentColor = Color.White
//            ), shape = RoundedCornerShape(size = 4.dp)
//        ) {
//
//            Text(text = "Update Memoir", style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium))
//
//        }
//
//    }
//}

@Preview
@Composable
fun Updateprev() {
    UpdateProductsScreen(rememberNavController(), id = "")
}