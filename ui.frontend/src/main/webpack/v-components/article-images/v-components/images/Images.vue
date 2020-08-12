<template>
    <div class="cmp_article_images-list">
        <p>images group side</p>
        <ul v-if="imagesData.images.length">
            <li 
                v-for="imageObject in imagesData.images"
                :key="imageObject.fileReference"
            >
                <img :src="imageObject.fileReference" alt=""/>
            </li>
		</ul>
    </div>
</template>

<script>

export default {
    props: {
        imagesData: Object,
        default: () => ({})
    },
    
};
</script>

<style lang="scss" scoped>
@import "./images_default";
@import "./images_media";
</style>