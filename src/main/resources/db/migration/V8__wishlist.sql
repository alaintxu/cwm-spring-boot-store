CREATE TABLE `wishlist` (
    `user_id` BIGINT NOT NULL,
    `product_id` BIGINT NOT NULL,
    FOREIGN KEY (`user_id`) REFERENCES `users`(`id`) ON DELETE CASCADE,
    FOREIGN KEY (`product_id`) REFERENCES `products`(`id`) ON DELETE CASCADE,
    PRIMARY KEY (`user_id`, `product_id`)
);