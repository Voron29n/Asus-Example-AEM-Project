<template>
    <div class="footer-socials">
        <p>socials group side</p>
    </div>
</template>

<script>

export default {
    props: {
        socialsData: Object,
        default: () => ({})
    },
    
};
</script>

<style lang="scss">
@import "./socials_default";
@import "./socials_media";
</style>