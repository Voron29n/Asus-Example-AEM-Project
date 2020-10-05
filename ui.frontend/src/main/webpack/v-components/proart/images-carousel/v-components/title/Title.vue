<template>
    <div class="col l12 m12 s12 always__on__top">
        <div class="wd_content text_animation large_text-center medium_text-center small_text-left wd_content-main">
            <div class="content_slogan text-gradient-gold">
                <span class="slogan-text">{{titleData}}</span>
            </div>
        </div>
    </div>
</template>

<script>

export default {
    props: {
        titleData: String,
    },
    
};
</script>

<style lang="scss">
@import "./title_default";
@import "./title_media";
</style>