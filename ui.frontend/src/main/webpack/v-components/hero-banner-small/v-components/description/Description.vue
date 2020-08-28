<template>
    <div>
        <h3 class="banner-small-sub-title">{{descriptionData.heroDescription}}</h3>
    </div>
</template>

<script>

export default {
    props: {
        descriptionData: Object,
    },
};
</script>

<style lang="scss">
@import "./description_default";
@import "./description_media";
</style>