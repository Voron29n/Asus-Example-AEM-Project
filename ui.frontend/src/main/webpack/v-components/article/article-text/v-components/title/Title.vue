<template>
    <div class="cmp_article_text-title">
        <br>
        <h3>{{titleData.textTitle}}</h3>
    </div>
</template>

<script>

export default {
    props: {
        titleData: Object,
    },
    
};
</script>

<style lang="scss">
@import "./title_default";
@import "./title_media";
</style>