package com.example.productexplorer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.productexplorer.ui.theme.ProductExplorerTheme

@Composable
fun ProductDetailScreen(
    product: ProductUi,
    onAddToCartClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp)
    ) {
        ProductImage(product.title, Modifier.fillMaxWidth().padding(bottom = 16.dp))
        ProductHeader(product.title, product.brand, product.category)
        ProductPriceCard(product.price, product.discountPercentage, Modifier.fillMaxWidth().padding(top = 16.dp))
        ProductRating(product.rating, Modifier.padding(top = 16.dp))
        ProductAvailabilityCard(product.stock, product.shippingInformation, Modifier.fillMaxWidth().padding(top = 16.dp))
        ProductDescription(product.description, Modifier.padding(top = 16.dp))
        Button(onClick = onAddToCartClick) { Text("Ajouter au panier") }
    }
}

@Composable
fun ProductHeader(title: String, brand: String, category: String, modifier: Modifier = Modifier) {
    Column(modifier) {
        Text(title, style = MaterialTheme.typography.headlineSmall)
        Text(brand, style = MaterialTheme.typography.titleMedium)
        Text(category, style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun ProductPriceCard(price: Double, discountPercentage: Double, modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(16.dp)) {
            Text("$price €", style = MaterialTheme.typography.headlineSmall)
            Text("Remise : $discountPercentage %", style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
fun ProductImage(productTitle: String, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(android.R.drawable.ic_menu_gallery),
        contentDescription = "Image du produit $productTitle",
        modifier = modifier
    )
}

@Composable
fun ProductRating(rating: Double, modifier: Modifier = Modifier) {
    Row(modifier) {
        Icon(Icons.Default.Star, contentDescription = "Note du produit")
        Text("$rating / 5", modifier = Modifier.padding(start = 8.dp))
    }
}

@Composable
fun ProductAvailabilityCard(stock: Int, shippingInformation: String, modifier: Modifier = Modifier) {
    Card(modifier) {
        Column(Modifier.padding(16.dp)) {
            Text("Disponibilité", style = MaterialTheme.typography.titleMedium)
            Text("Stock : $stock unités", style = MaterialTheme.typography.bodyMedium)
            Text(shippingInformation, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Composable
fun ProductDescription(description: String, modifier: Modifier = Modifier) {
    Column(modifier) {
        Text("Description", style = MaterialTheme.typography.titleMedium)
        Text(
            description,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProductDetailScreenPreview() {
    ProductExplorerTheme {
        ProductDetailScreen(sampleProduct(), onAddToCartClick = {})
    }
}
